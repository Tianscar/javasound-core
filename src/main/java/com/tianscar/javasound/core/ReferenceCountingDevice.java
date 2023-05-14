/*
 * Copyright (c) 2003, 2007, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.tianscar.javasound.core;

import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;



/** MidiDevice that can use reference counting for open/close.
 * This interface is intended to be used by MidiSystem.getTransmitter() and
 * MidiSystem.getReceiver().
 *
 * @author Matthias Pfisterer
 */
public interface ReferenceCountingDevice {
    /** Retrieve a Receiver that opens the device implicitly.
     * This method is similar to MidiDevice.getReceiver(). However, by calling this one,
     * the device is opened implicitly. This is needed by MidiSystem.getReceiver().
     */
    public Receiver getReceiverReferenceCounting() throws MidiUnavailableException;

    /** Retrieve a Transmitter that opens the device implicitly.
     * This method is similar to MidiDevice.getTransmitter(). However, by calling this one,
     * the device is opened implicitly. This is needed by MidiSystem.getTransmitter().
     */
    public Transmitter getTransmitterReferenceCounting() throws MidiUnavailableException;
}